const fs = require('fs')

const getCV = (req, res) => {
    educations = fs.readFileSync("data/education", { encoding: "utf-8" });
    educations = JSON.parse(String(educations));
    
    edus = [];
    
    for (let key in educations) {
        edus.push(educations[key]);
    }
    
    res.render("cv", {name: "Azmayen Sabil", educations: edus, phone: "01833352501", home: "Dhaka", email: "azmayen@email.com", job:"Student"})
}

module.exports = {cvDao : getCV}