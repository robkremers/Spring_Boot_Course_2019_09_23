<<<<<<< HEAD
=======
https://github.com/robkremers/Spring_Boot_Course_2019_09_23.git

>>>>>>> b3dc3bb6050de78ba7a4caacebe982ef97d6c773
Date	: 2019-12-08.

Purpose:
Preservation of code created on behalf of an introductory course regarding Spring Boot 
and related topics

--------------------------------------------------------------------------------------------------
Todo:

--------------------------------------------------------------------------------------------------
Git:
The application will be available on: 
https://github.com/robkremers/Spring_Boot_Course_2019_09_23

git:

Initial:
git init
git pull https://github.com/robkremers/Spring_Boot_Course_2019_09_23.git
git status
git add .
git commit -m "Initial commit."
git pull https://github.com/robkremers/Spring_Boot_Course_2019_09_23.git
git remote add origin https://github.com/robkremers/Spring_Boot_Course_2019_09_23.git
git push -u origin master
git status

history

Normal:
If during the local work changes have been implemented it is advantageous to use:
git status
git add .
git commit --amend 
# or
git commit --amend --no-edit
git push -u origin master
git status

Using git commit --amend --no-edit prevents problematic execution of squashing.
(because there is only one commit locally until the commit is pushed to the repository).
