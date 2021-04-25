1)http://localhost:8080/ will shows the index page.
If the form passes validation. It redirects to 
http://localhost:8080/collegeList else it shows error about
the fields
 
2)http://localhost:8080/collegeList shows the list of college data

3)http://localhost:8080/pageHits shows the page hits count

4)For filtering list by optional get param enter following queries
http://localhost:8080/attr?attr=coursename
http://localhost:8080/attr?attr=collegename
http://localhost:8080/attr?attr=collegeid

5)Test file is in the src/test/java directory

Libraries implemented in project which are not covered in class
1)Implemented BootStrap. If we shrink the index web page
we can observe that it is mobile optimized.