//npm install mysql (set pakage.json)
//npm install --save mysql express (set pakage.json)
//npm install uuid4 (linepay API module)
//npm install crypto-js (linepay API module)
//npm install axios (linepay API module)


//only one item for test

function test() {

    //connect to mySQL
    var mysql = require('mysql');

    var con = mysql.createConnection({
        host: "localhost",
        user: "root",
        password: "0853770905",
        database: "face_project"
    });

    con.connect(function(err) {
        if (err) throw err;
        con.query("SELECT * FROM ShopCart", function(err, result, fields) {
            if (err) throw err;
            console.log(result);
        });
    });

    //linepay
    const uuid = require('uuid4')
        // 直接印出來
    console.log(uuid())
        // 輸出長這樣
        // 504ac11a-1888-4410-89b2-75382fef61b3

    const crypto = require('crypto-js')
        // 裝好記得要引入
    let key = '2510510799f9546c55179f2c25a72923'
    let nonce = uuid()
    let requestUri = '/v3/payments/request'
    let order = {
        amount: 180,
        currency: 'TWD',
        orderId: 'order504ac11a-1888-4410-89b2-75382fef61b3',
        packages: [{
            id: '20191011I001',
            amount: 180,
            name: '飲料',
            products: [{
                name: '漂浮冰淇淋',
                quantity: 1,
                price: 180
            }]
        }],
        redirectUrls: {
            confirmUrl: 'https://6ddcf789.ngrok.io/confitmUrl',
            cancelUrl: 'https://6ddcf789.ngrok.io/cancelUrl'
        }
    }
    let encrypt = crypto.HmacSHA256(key + requestUri + JSON.stringify(order) + nonce, key)

    // 然後再轉成Base64
    let hmacBase64 = crypto.enc.Base64.stringify(encrypt)


    let configs = {
        headers: {
            'Content-Type': 'application/json',
            'X-LINE-ChannelId': 1657758861,
            'X-LINE-Authorization-Nonce': nonce,
            'X-LINE-Authorization': hmacBase64
        }
    }


    const axios = require('axios')
        // 裝好記得要引入

    axios.post('https://sandbox-api-pay.line.me/v3/payments/request', order, configs).then(res => {
        console.log(res.data)
    })

    // clear shpocart
    // con.connect(function(err) {
    //     if (err) throw err;
    //     var sql = "DELETE * FROM ShopCart WHERE no = '?'";
    //     con.query(sql, function(err, result) {
    //         if (err) throw err;
    //         console.log("ShopCart items deleted: " + result.affectedRows);
    //     });
    // });
}