Feature-Scoped Structure



app/
  games/
    page.jsx                ← list page

    GameTable.jsx           ← table component
    actions.js              ← server actions
    service.js              ← REST API calls

    new/
      page.jsx              ← create page
      GameForm.jsx          ← create/edit form

    [id]/
      page.jsx              ← details page
      GameDetails.jsx       ← details component

      edit/
        page.jsx            ← edit page
        

SERVICE RULES
-------------

Create a file:

app/<feature>/service.js

This file is responsible for calling the backend REST API.

Base URL format:

http://localhost:8080/<feature>

Example:
Feature: games
Base URL:
http://localhost:8080/games


CRUD ENDPOINTS
--------------

POST   /<feature>
GET    /<feature>
GET    /<feature>/{id}
PUT    /<feature>/{id}
DELETE /<feature>/{id}


SERVICE METHODS
---------------

Implement the following functions:

getAll<Feature>()
get<Feature>ById(id)
create<Feature>(data)
update<Feature>(id, data)
delete<Feature>(id)


IMPLEMENTATION RULES
--------------------

- Use fetch() for HTTP calls
- Use appropriate HTTP methods:
  - GET
  - POST
  - PUT
  - DELETE
- Send JSON body for POST and PUT
- Include header:
  Content-Type: application/json
- Return JSON response
- Handle HTTP errors gracefully


FORM SUBMISSION RULES
---------------------

The form must use Next.js server actions with useActionState.

Initialize action state:

const [state, action, pending] = useActionState(serverAction, initialState)

Where:

state   → contains validation errors or success state
action  → form action handler
pending → boolean loading indicator


FORM ACTION
-----------

Attach the action to the form:

<form action={action}>


LOADING STATE
-------------

Use the pending flag to disable the submit button while the request is processing.


SERVER VALIDATION
-----------------

All server actions must validate input using Zod.

Validation rules:

- Define a Zod schema inside the server action
- Validate form data before processing
- If validation fails:
  - return an object containing validation errors


ERROR HANDLING
--------------

Server action must return validation errors to useActionState.

Example state structure:

{
  errors: {
    fieldName: "Error message"
  }
}

The form component must display these errors under each input field.


SUCCESS BEHAVIOR
----------------

If the operation succeeds:

- redirect the user to the feature home page

Example:

/<feature>


EDIT FORM BEHAVIOR
------------------

Edit page must:

- fetch existing data
- pass it as initialData to the form
- call update server action


CREATE FORM BEHAVIOR
--------------------

Create page must:

- render the form with empty initialData
- call create server action

FORM UX RULES
-------------

- Disable submit button when pending = true
- Show validation error messages below each field
- Preserve user input if validation fails







