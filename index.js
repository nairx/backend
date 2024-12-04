import express from "express";
const app = express();


// import userRouter from "./routes/userRoutes.js";
import mongoose from "mongoose";
import cors from "cors";
// import productRouter from "./routes/productsRoutes.js";

app.use(express.json());
app.use(cors());

// app.use("/users", userRouter);

app.use("/products", productRouter)

mongoose
  .connect("mongodb://127.0.0.1:27017/ecomm1")
  .then(() => {
    app.listen(8080, () => {
      console.log("Server Started on port 8080");
    });
  })
  .catch((error) => {
    console.log(error);
  });
