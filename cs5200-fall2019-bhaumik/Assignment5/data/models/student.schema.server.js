const mongoose = require('mongoose');
module.exports = mongoose.Schema({
                                          _id: Number,
                                          username: String,
                                          firstName: String,
                                          lastName: String,
                                          password: String,
                                          gradYear: Number,
                                          scholarship: Number,
                                      }, {collection: 'students'}
);
