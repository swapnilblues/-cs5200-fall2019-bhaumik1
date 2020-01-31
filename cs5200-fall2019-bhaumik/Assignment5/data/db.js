module.exports = function () {
    const mongoose = require('mongoose');
    mongoose.connect('mongodb+srv://admin1234:admin1234@cs5200-assignment5-bhaumik-hnqu8.mongodb.net/test?retryWrites=true&w=majority', {useNewUrlParser: true});

};

