const express = require('express')
const router = express.Router()
const fs = require('fs')
const {cvDao} = require('./controllers/cvController')

router.get("/", (req, res) => {
    res.send("Inside Home Page");
});
  
router.get("/about", (req, res) => {
    res.send("Inside About Page");
});

// router.get("/cv", (req, res) => {
//     educations = fs.readFileSync("data/education", { encoding: "utf-8" });
//     educations = JSON.parse(String(educations));

//     edus = [];

//     for (let key in educations) {
//         edus.push(educations[key]);
//     }

//     res.render("cv", {name: "Azmayen Sabil", educations: edus, phone: "01833352501", home: "Dhaka", email: "azmayen@email.com", job:"Student"})
// })

router.get("/cv", cvDao) 

module.exports = router