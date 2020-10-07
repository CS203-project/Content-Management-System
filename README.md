# content-management-system

### API Documentation
* [POST /contents](https://github.com/CS203-project/content-management-system#post-contents)
* [PUT /contents/{content_id}](https://github.com/CS203-project/content-management-system#put-contentscontent_id)
* [GET /contents/{content_id}](https://github.com/CS203-project/content-management-system#get-contentscontent_id)
* [DELETE /contents/{content_id}](https://github.com/CS203-project/content-management-system#delete-contentscontent_id)

#### POST /contents
```
// ROLE_ANALYST
// ROLE_MANAGER

{
  "title":"The title of the advisory or news",
  "summary":"The short summary of the content item",
  "content": "The text of the content item",
  "link":"https://link.to.externalcontent"
}
```
#### PUT /contents/{content_id}
```
// ROLE_ANALYST - cannot approve
// ROLE_MANAGER - can approve

{
  "id": 1,
  "summary": "The short summary of the content item", 
  "content": "The text of the content item",
  "link":"https://link.to.externalcontent",
  "approved": true
}
```
#### GET /contents/{content_id}
```
// All roles, if content approved

{
  "id": 1,
  "summary": "The short summary of the content item", 
  "content": "The text of the content item",
  "link":"https://link.to.externalcontent",
}
```
#### DELETE /contents/{content_id}
```
// ROLE_ANALYST
// ROLE_MANAGER

{
  "id": 1
}
```
