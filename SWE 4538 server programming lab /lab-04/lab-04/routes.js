const express = require("express");
const router = express.Router();
const homeController = require("./controllers/homeController");
const bookController = require("./controllers/bookController");

router.get("/", homeController.getHome);
router.get("/book-list", bookController.getBookList);
router.get("/books", bookController.getBook);
router.post("/books", bookController.postBook);
router.get("/book-list/deleteBook/(:id)", bookController.deleteBook);
router.get("/book-list/updatebook/(:id)", bookController.updateBook);
router.post("/book-list/updatebookInfo/(:id)", bookController.updateBookInfo);

module.exports = router;
