//const books = require("./../models/books");
const bookModel = require("./../models/books");

const getBookList = async (req, res) => {
  let data = [];
  let books = [];
  try {
    data = await bookModel.find();
    console.log(data);
    data.forEach((book) => {
      books.push({ name: book.name, author: book.author, genre: book.genre, id: book._id });
    });
  } catch (error) {
    console.log(error);
  } finally {
    res.render("bookList", { books: books });
  }
};

const getBook = (req, res) => {
  res.render("addBooks");
};

const postBook = (req, res) => {
  const data = new bookModel({
    name: req.body.name,
    author: req.body.author,
    genre: req.body.genre,
  });
  data
    .save()
    .then(() => {
      console.log("Data Saved Successfully!");
    })
    .catch((error) => {
      console.log(error);
    })
    .finally(() => {
      res.redirect("/books");
    });
};

const deleteBook = async (req, res) => {
  const b_id = req.params.id;
  console.log(b_id)
  const book = await bookModel.findByIdAndDelete(b_id)
  book.delete();
  res.json(book)
}

const updateBook = async (req, res) => {
  const b_id = req.params.id;
  //console.log(b_id)
  res.render("updateBookList", {name: req.params.name, author: req.body.author, genre: req.body.genre, id: b_id})
}

const updateBookInfo = async (req, res) => {
  console.log(req.params.id)
  const book = await bookModel.findByIdAndUpdate(req.params.id,{
    name: req.body.name,
    author: req.body.author,
    genre: req.body.genre,
  },
  {new: true})
  res.render("books")
}

module.exports = { getBookList, getBook, postBook, deleteBook, updateBook, updateBookInfo };
