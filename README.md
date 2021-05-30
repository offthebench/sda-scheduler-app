# SDA Scheduler application
    
### Requirements

Create a class hierarchy

```     
Person.java - firstname
            - lastname
            - dateOfBirth
Trainer.java (extends Person) - isAuthorized (boolean)
Student.java (extends Person) - hasPreviousJavaKnowledge (boolean)
```
     
Create a Group class which has
```
name (Java2Gdansk, Tester3Bucharest, etc)
one trainer
a list of students
```


    
1. Manually initialize 15 students; 4 groups and 3 trainers;

1. Store all students in a list; all groups in a list; all trainers in a list;

1. Assign a trainer to each group

1. Assign 2-3 students to each group

1. Ensure the fact that a group will only have distinct students (How would you do that?)

1. Ensure the fact that a group will only have a maximum of 5 students; When you try to add a 6th one throw an MaximumNumberOfStudentsReached exception

1. Display all students in a group sorted alphabetically by lastName

1. Display the group with the maximum number of students

1. Display all students younger than 25, from all groups

1. Display all students grouped by trainer that teaches to them (eg. Trainer1 - stud1, stud3, stud4; Trainer2 - stud2, stud 10) - regardless of the group they're part of (If you were to store this information in a data structure what would you use?)

1. Display all students with previous java knowledge

1. Display the group with the highest number of students with no previous java knowledge

1. Remove all the students younger than 20 from all groups