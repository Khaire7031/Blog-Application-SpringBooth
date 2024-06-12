const express = require('express');
const visitRoutes = require('./routes/visitRoutes');

const app = express();

app.use(express.json());
app.use('/api', visitRoutes);

module.exports = app;
