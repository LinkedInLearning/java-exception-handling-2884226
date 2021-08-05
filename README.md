# Java Exception Handling
This is the repository for the LinkedIn Learning course Java Exception Handling. The full course is available from [LinkedIn Learning][lil-course-url].

![Java Exception Handling][lil-thumbnail-url] 

As you build any application, you can’t just assume that everything will run as expected. There are so many things that could cause your applications to not function properly or even crash. This course aims to teach developers how to handle such unforeseen scenarios in applications. Join instructor Cecili Reid as she teaches you the different types of exceptions, how to handle exceptions, and how to test an application to ensure it handles exceptions as expected. Cecili uses a sample Spring Boot web app as a case study and walks through practical scenarios where you’d want to use exception handling in that application. She starts with an initial application that doesn’t have exception handling mechanisms, and as she walks through each concept, she shows you how to improve the application by applying the concepts taught in each chapter. Cecili also shares some best practices to follow when handling exceptions in your applications.

## Instructions
This repository has branches for each of the videos in the course. You can use the branch pop up menu in github to switch to a specific branch and take a look at the course at that stage, or you can add `/tree/BRANCH_NAME` to the URL to go to the branch you want to access.

## Branches
The branches are structured to correspond to the videos in the course. The naming convention is `CHAPTER#_MOVIE#`. As an example, the branch named `02_03` corresponds to the second chapter and the third video in that chapter. 
Some branches will have a beginning and an end state. These are marked with the letters `b` for "beginning" and `e` for "end". The `b` branch contains the code as it is at the beginning of the movie. The `e` branch contains the code as it is at the end of the movie. The `main` branch holds the final state of the code when in the course.

When switching from one exercise files branch to the next after making changes to the files, you may get a message like this:

    error: Your local changes to the following files would be overwritten by checkout:        [files]
    Please commit your changes or stash them before you switch branches.
    Aborting

To resolve this issue:
	
    Add changes to git using this command: git add .
	Commit changes using this command: git commit -m "some message"


### Instructor

Cecili Reid                   

Check out my other courses on [LinkedIn Learning](https://www.linkedin.com/learning/instructors/cecili-reid).

[lil-course-url]: https://www.linkedin.com/learning/java-exception-handling
[lil-thumbnail-url]: https://cdn.lynda.com/course/2884226/2884226-1627922016081-16x9.jpg
