# News
This is a project I developed to train my basic skills of spring boot, thymeleaf, MVC and JPA so the security
and bootstrap are not the point of this project.
On News you can make your posts, edit, delete, find some specific post from the search menu on the navbar or even make
your comments. You can also manage the level of the users.

1- How to install:
1.1 Maven:  https://www.javatpoint.com/how-to-install-maven
1.2 To compile the project: Just open the console on the news folder and type "mvn compile"
1.3 To execute: After the compile processes are done, open the console on the news folder and type "mvn spring-boot:run" (before it, make sure the news database exists).
News is running on http://localhost:8080.


2- User level:
There are 2 level of user, default level and the admin. On user table from database there 
are only 2 options: user (default) or admin.
2.1- user (default): Can only make comments and the navbar will have only the option to logout.
2.2- admin: Can write a new post through the menu "add post" at the navbar, edit and delete posts (theses options
are in the bottom of the post) and the admin can edit or remove a use (User Find from the navbar).

3- Search post: A simple engine that find out a post containing the specific text writed.

4- User Find: The same as the Search Post, only find a user containing the specific text writed.

5- Pages: Every single page is a thymeleaf fragment and the navbar, footer e etc as well. 
srs/main/resources/templates/ contains all the fragment and pages files. Each page fragment (index for example) needs to
load the base page on Controller.

5.1- .../static contains the images, css and the js files.
5.2- .../fragments contains the navbar and footer inside the fragments folder. 
5.3- .../userNavbar contains the specific user navbar of each user level.
5.4- .../pages contains the pages, except the base page.

6- Database: In this project we are using mysql.
The setup file (application.properties) is in srs/main/resources/ folder. Just make sure the database news
exists or change the database name at <spring.datasource.url> property.
