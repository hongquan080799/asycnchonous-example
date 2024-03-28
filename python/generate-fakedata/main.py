from faker import Faker
import mysql.connector
import random

fake = Faker()

# Create a connection to the MySQL database
cnx = mysql.connector.connect(user='root', password='12345678',
                              host='127.0.0.1',
                              database='aavn')

cursor = cnx.cursor()
randModify = ['quandt', 'cuong', 'tung', 'hieu', 'suong', 'hai', 'minh']
# Generate and insert 1000 rows of dummy data
for _ in range(500000):
    name = fake.name()
    email = fake.email()
    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    gender = bool(random.getrandbits(1))
    address = fake.address()
    created_by = updated_by = random.choice(randModify)
    cursor.execute("INSERT INTO user_info (name, address, email, description, gender, created_by, updated_by) VALUES (%s, %s,%s, %s,%s, %s, %s)", (name, address, email, description, gender, created_by, updated_by), 1000)

cnx.commit()

cursor.close()
cnx.close()
