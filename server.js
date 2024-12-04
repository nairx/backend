import express from "express";
import cors from 'cors'
const app = express()

app.use(cors())
app.listen(8080,()=>{
  console.log("Server started at port 8080")
})

// app.get("/",(req,res)=>{
//   res.send("Hello World")
// })

import mongoose from "mongoose";

import { MongoClient, ObjectId } from "mongodb";
const uri = "mongodb://127.0.0.1:27017"
const client = new MongoClient(uri)
const db = client.db("ecomm1")

app.get("/", async (req, res) => {
  const items = await db.collection("products").find().toArray()
  res.status(200).json(items);
});

app.use(express.json());
// app.use(cors());

// app.get("/", async (req, res) => {
//     const items = await db.collection("products").find().toArray()
//     res.status(200).json(items);
//   });


  app.post("/", async (req, res) => {
    const { name, price } = req.body;
    const data = {
      name: name,
      price: price,
    };
    const newProduct = await db.collection("products").insertOne(data);
    res.status(200).json(newProduct);
  });
  