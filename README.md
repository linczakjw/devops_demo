# DevOps Demonstrations
The point of this repo is to really begin to explore all of the concepts of DevOps, building on things slowly over time.  This is also also to help demonstrate knowledge I've gained in knowing what technologies are doing what, when to use them, and how to architect a scalable architecture using these tools and technologies.

## The Project
The project I will be implementing is a simple online form that allows you to upload a GIF or JPEG and convert it to a PNG image as your output.  Over the course of the project, we may add more functionality to demonstrate other core concepts, but the project lends itself to a service that can be easily broken out into simple components and scaled quickly.

We'll work out first the basics:

1. Using a (pretty crappy by today's standards) Mac, we'll setup Docker Desktop so that we can download and install docker images from the Hub, as well as create our own images.
2. Setup and test image processing microservice for processing images
3. Add a layer on top using Spring Boot to interact with that microservice by having an upload form and pushing that the image uploaded to the image processing microservice for processing and results
4. Work out the storage aspect of these images that are being uploaded in more detail
5. Migrate these containers to AWS to run in that environment
6. Think about how to scale up these services when the volume of requests gets higher and meets certain operating thresholds
7. Other thoughts about where to go next with scaling further up both within and outside of AWS
8. Discuss security implications and how to mitigate them in the environment by adding segmentation and logging

At least that's the plan, anyway.  I'm not an expert by any stretch, but I'm learning based on the experiences that I've had in the past and wanted to share my notes while I'm learning.  If there are better ways to think about these things, by all means share them!