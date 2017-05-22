## Synopsis

I'm applying for a position with Derive Systems.  They make high-end auto performance parts.  They tasked me to build an inventory system using Objectify and running in Google Application Engine.

## What is done
It is a REST interface with 2 types of objects; Item and Purchase Order.  It uses Objectify and GAE.  It's fully tested, with both unit and postman-based functional tests.

## What is not done
There's still a lot of basic functionality needed before it can be considered an inventory management system.  Sales orders, transfer orders, reports, accounts payable, payment processing, etc.  If this is for car parts, then we don't really need unit of measure support.  That can all be added on to this framework.

## Running the tests
Postman tests are in src/test/postman.  You'll need to import the collection and one or both of the environments.  The gae environment is configured to work against my personal GAE account, but it's pretty easy to modify if you want to run on your own server.

You can also use newman command-line runner, if you want.  
```
sudo npm install -g newman 
newman run -e derive_gae.postman_environment.json Derive\ Inventory.postman_collection.json 

```


## Lessons learned during development
I did a quick sample app on GAE a few years ago, but I have never built anything large on it.  I was surprised to find out that there are 2 types of GAE environments; standard and flex.  I started using spring boot, but it's not supported on standard.  Objectify hasn't upgraded to flex yet, and so you can't use spring boot and Objectify together.  

As well, I still haven't quite figured out how to use Objectify's parent/child relationships.  That's why Sales Orders are not done yet.  You need strong relationship modeling with sales orders, and I wasn't able to figure it out in time.  Basically, I think I understand the way Objectify does it, but the Keys are not easy to serialize to Java.  I started writing a custom serializer/deserializer, but ran out of time.

 
