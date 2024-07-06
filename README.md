PostgresSQL query
########################################
select * from student;

INSERT INTO student (first_name, last_name, email, age, marks, attendance, promotion_status)
VALUES ('John', 'Doe', 'john.doe@example.com', 20, 50, 57, false);


INSERT INTO student (first_name, last_name, email, age, marks, attendance, promotion_status)
VALUES ('Awadhesh', 'Patel', 'awadhesh.patel@gmail.com', 25, 85, 97, true);

DELETE FROM student WHERE student_id = 6;

##########################################################

The localhost URL for accessing the endpoints of your StudentController would be structured 
as follows, assuming your Spring Boot application is running on the default port 8080:

Base URL
http://localhost:8080/students

1. Index Page
   GET http://localhost:8080/students/
2. Get All Students
   GET http://localhost:8080/students
3. Get Student by ID
   GET http://localhost:8080/students/{id}
4. Add Student
   POST http://localhost:8080/students
   With a JSON body,
   {
   "first_name": "Abhi",
   "last_name": "D",
   "email": "abhi.dgmail.com",
   "age": 30,
   "marks": 60,
   "attendance": 67,
   "promotionStatus": true
   }
5. Update Student
   PUT http://localhost:8080/students/{id}
   Replace {id} with the actual student ID you want to update, with a JSON body,
   {
   "first_name": "Cindy",
   "last_name": "ji",
   "email": "cindy.jigmail.com",
   "age": 35,
   "marks": 85,
   "attendance": 90,
   "promotionStatus": true
   }
6. Delete Student
   DELETE http://localhost:8080/students/{id}
7. Update Promotion Status
   Replace {id} with the actual student ID whose promotion status you want to update.
   PUT http://localhost:8080/students/{id}/updatePromotionStatus
