var http = require('http');
const fs = require('fs').promises;

var server = http.createServer((req, res) => {
  console.log(req.method + " " + req.url);
  
  // response with status code 200 and content type text/htm
  if (req.method == 'POST') {
    // console.log('POST')
    var body = '';
    req.on('data', function(data) {
      body += data;
      console.log('Request body: ' + body);
      res.writeHead(200, {'Content-Type': 'text/html'})
      res.end();
    })
  } else{
    //console.log(__dirname);
    fs.readFile(__dirname + "/public/index.html")
        .then(contents => {
        res.setHeader("Content-Type", "text/html");
        res.writeHead(200);
        //res.write('<h1>Hello, world</h1>')
        res.write(contents);
        res.end();
        })
  }
});

server.listen(8000);