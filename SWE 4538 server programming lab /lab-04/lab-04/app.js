require("dotenv").config();
const bodyParser = require("body-parser");
const express = require("express");
const mongoose = require("mongoose");
const router = require("./routes");
const app = express();
const port = 3000;

const database_url = process.env.DATABASE_URL;

mongoose
  .connect(database_url)
  .then(() => {
    console.log("Database connected!");
  })
  .catch(() => {
    console.log("Could not connect to database!");
  });

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(express.static("public"));
app.set("view engine", "ejs");
app.set("views", __dirname + "/views");

app.use(router);
app.listen(port, () => {
  console.log(`App is running at https://localhost:${port}`);
});
