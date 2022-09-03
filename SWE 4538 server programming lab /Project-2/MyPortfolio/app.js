const express = require('express')
const app = express()
const router = require('./router')
const port = 3000

app.use(express.static("public"));
app.set("view engine", "ejs"); 
app.set("views", __dirname + "/views");

app.use(router)

app.listen(port, (req, res) => {
    console.log(`Example app listening on port ${port}!`);
});