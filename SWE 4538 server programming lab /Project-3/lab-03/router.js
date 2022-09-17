const express = require("express");
const router = express.Router();

const { getCV } = require("./controllers/CvController");

const fs = require("fs");

router.get("/", getCV);

router.get("/form", (req,res) => {
    res.render('form');
});

router.post("/form",function(req,res){
    var username=req.body.username;
    var email=req.body.email;
    var f={username: username,email:email};
    // Form.create(f,function(err,newlyCreatedForm){
    //     if(err)
    //     {
    //         console.log(err);
    //     }else{
    //         res.redirect("/result");
    //         console.log(f);
    //     }
    // });

    console.log(f);
    res.render("cv", { name: username,  educations: edus });
});

module.exports = router;
