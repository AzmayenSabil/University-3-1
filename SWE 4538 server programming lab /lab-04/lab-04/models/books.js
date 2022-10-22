const mongoose = require("mongoose");

const schema = new mongoose.Schema({
  name: {
    required: true,
    type: String,
  },
  author: {
    required: true,
    type: String,
  },
  genre: String,
});

module.exports = mongoose.model("Books", schema);
