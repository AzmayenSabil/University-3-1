const express = require("express"); //Includes the express library
const bodyParser = require("body-parser"); //Includes the body parser
const { engine } = require("express-handlebars"); //Includes the handlebars Library 
const app = express(); //Creates an Express Application
const router = require("./router");
const port = 3000;

/*** 
app.get() takes a callback function as an argument that will be invoked
whenever there is an HTTP GET request 
with a path ('/') relative to the site root.
The callback function takes a request and a response object as arguments,
and calls send() on the response to return the string "Hello World!"
The Express application object also provides methods to define route handlers
 for all the other HTTP verbs, which are mostly used in exactly the same way:
copy(), delete(), get(), head(), merge(), options(), patch(), post(), put(), etc,.
There is a special routing method, app.all(), which will be called in 
response to any HTTP method.
***/
// app.get("/", function (req, res) {
//   res.send("Hello World!");
// });

app.use(bodyParser.urlencoded({extended:true}));
app.use(express.static("public"));

app.set("view engine", "ejs"); // Setting EJS as template engine

app.set("views", __dirname + "/views"); // Setting the directory for the view files

app.use(router); // Router Middleware

app.listen(port, function () {
  //starts up the server on a specified port ('3000')
  console.log(`Example app listening on port ${port}!`);
});
