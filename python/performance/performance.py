import csv
import matplotlib.pyplot as plt
import time

import psutil


def record_usage(pid, filename, interval=1):
  """
  Records memory and CPU usage for a process with the given PID until interrupted by the user,
  saving the data to a CSV file and plotting it in two separate charts. Memory usage is recorded in MB.

  Args:
      pid (int): The process ID (PID) of the process to monitor.
      filename (str): The filename to save the data to (CSV format).
      interval (int, optional): The interval (in seconds) between recordings. Defaults to 1.
  """

  timestamps = []
  cpu_usages = []
  memory_usages_mb = []

  try:
    with open(filename, 'w', newline='') as csvfile:
      writer = csv.writer(csvfile)
      writer.writerow(["Timestamp", "CPU Usage (%)", "Memory Usage (MB)"])

      while True:
        try:
          process = psutil.Process(pid)
          cpu_usage = process.cpu_percent(interval=1)
          memory_info = process.memory_info()
          memory_usage_mb = memory_info.rss / (1024 * 1024)  # Convert to MB

          timestamps.append(time.strftime("%H:%M:%S"))
          cpu_usages.append(cpu_usage)
          memory_usages_mb.append(memory_usage_mb)

          writer.writerow([time.strftime("%H:%M:%S"), cpu_usage, memory_usage_mb])
          time.sleep(interval)

        except KeyboardInterrupt:
          print("Recording interrupted by user.")
          break

      print(f"Recording for PID {pid} completed. Data saved to {filename}")

    # Create two subplots for CPU and memory usage
    fig, (ax1, ax2) = plt.subplots(2, 1, figsize=(20, 6))

    # Plot CPU usage
    ax1.plot(timestamps, cpu_usages, label="CPU Usage (%)")
    ax1.set_xlabel("Time")
    ax1.set_ylabel("CPU Usage (%)")
    ax1.set_title(f"CPU Usage for PID {pid}")
    ax1.legend()

    # Plot memory usage
    ax2.plot(timestamps, memory_usages_mb, label="Memory Usage (MB)")
    ax2.set_xlabel("Time")
    ax2.set_ylabel("Memory Usage (MB)")
    ax2.set_title(f"Memory Usage for PID {pid}")
    ax2.legend()

    plt.tight_layout()

    # Save the plot as an image
    plt.savefig(f"{filename[:-4]}.png")  # Replace CSV extension with PNG
    print(f"Plot saved as {filename[:-4]}.png")

  except psutil.NoSuchProcess:
    print(f"Process with PID {pid} not found.")


if __name__ == "__main__":
  pid = int(input("Enter the PID of the process: "))
  filename = input("Enter the desired filename (e.g., usage_data.csv): ")
  record_usage(pid, filename)
