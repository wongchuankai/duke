# User Guide

## Features 


 ### `1. todo` - add a task to be done

tasks without any date/time attached to it e.g., visit new theme park

`todo (description of task)`

Example of usage: 

`todo visit new theme park`

Expected outcome:

`____________________________________________________________
      Got it. I've added this task: 
        [T][✗] visit new theme park
      Now you have 5 tasks in the list.
     ____________________________________________________________
`

### `2. event` - add an event task to be done

tasks that start at a specific time and ends at a specific time e.g., team project meeting on 2/10/2019 2-4pm

`event (description of event task) /at (time/place)`

Example of usage: 

`event team project meeting /at 2/10/2019 2-4pm`

Expected outcome:

`____________________________________________________________
      Got it. I've added this task: 
        [E][✗] project meeting (at: Mon 2-4pm)
      Now you have 7 tasks in the list.
     ____________________________________________________________`

### `3. deadline` - add an deadline task to be done

tasks that need to be done before a specific date/time e.g., submit report by 11/10/2019 5pm

`deadline (description of deadline task) /by (DD/MM/YYYY 24:hour format)`

Example of usage: 

`deadline submit project report /by 11/10/2019 1700`

Expected outcome:

`____________________________________________________________
      Got it. I've added this task: 
        [D][✗] submit project report (by: 11th of October 2019, 5.00pm)
      Now you have 6 tasks in the list.
     ____________________________________________________________`

### `4. list` - shows all the tasks in the list

Display all the tasks in the list back to the user when requested.

`list`

Example of usage: 

`list`

Expected outcome:

`____________________________________________________________
      Here are the tasks in your list:
      1.[T][✓] read book
      2.[D][✗] return book (by: June 6th)
      3.[E][✗] project meeting (at: Aug 6th 2-4pm)
      4.[T][✓] join sports club
      5.[T][✗] borrow book
     ____________________________________________________________`

### `5. find` - search for a keyword

Give users a way to find a task by searching for a keyword.

`find (keyword)`

Example of usage: 

`find book`

Expected outcome:

`____________________________________________________________
      Here are the matching tasks in your list:
      1.[T][✓] read book
      2.[D][✓] return book (by: June 6th)
     ____________________________________________________________`


### `6. delete` - deleting tasks from the list.

Give users a way to delete a specific task.

`delete (task number)`

Example of usage: 

`delete 3`

Expected outcome:

`____________________________________________________________
      Noted. I've removed this task: 
        [E][✗] project meeting (at: Aug 6th 2-4pm)
      Now you have 4 tasks in the list.
     ____________________________________________________________`

     
### `7. done` - mark tasks as done.

Mark tasks as done.

`done (task number)`

Example of usage: 

`done 2`

Expected outcome:

`____________________________________________________________
      Nice! I've marked this task as done: 
        [✓] return book
     ____________________________________________________________`
     
     
### `8. sort` - sort the tasks in the list.

Sort the task according to description lexicographically or type of task 
(todo task first followed by event task and then deadline tasks).

8.1 `sort desc`

Example of usage: 

`sort desc`

Expected outcome:

`____________________________________________________________
      Nice! I've marked this task as done: 
        [✓] return book
     ____________________________________________________________`
     

8.2 `sort type`

Example of usage: 

`sort type`

Expected outcome:

`____________________________________________________________
      Nice! I've marked this task as done: 
        [✓] return book
     ____________________________________________________________`
     
 ### `9. bye` - close the program safely.
 
 User cannot input anymore and close the program safely.
 
 `bye`
 
 Example of usage: 
 
 `bye`
 
 Expected outcome:
 
 `____________________________________________________________
       Bye. Hope to see you again soon!
      ____________________________________________________________`
    
### `10. help` - display a list of commands
 
 display a list of commands for users to view.
 
 `help`
 
 Example of usage: 
 
 `help`
 
 Expected outcome:
 
 `____________________________________________________________
       Bye. Hope to see you again soon!
      ____________________________________________________________`
    

## Usage

### `Keyword` - Describe action

Describe action and its outcome.

Example of usage: 

`keyword (optional arguments)`

Expected outcome:

`outcome`
