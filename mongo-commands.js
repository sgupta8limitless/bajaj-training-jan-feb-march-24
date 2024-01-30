db.products.insertMany([

    {name:"Samsung M51",price:34000,quantity:120,category:["Mobiles","Electronics"]},
    {name:"Water Bottle",price:70,quantity:350,category:["Home","Appliance"]},
    {name:"Plate",price:100,quantity:500,category:["Culinary","Home"]},
    {name:"Iphone Charger",price:2000,quantity:120,category:["Mobiles","Electronics"]},
    
    
])

db.products.updateMany({},{$set:{mainCategory:"Mobile",vendor:"Vinayak"}})

// to update or add a new property in existing doc 
// db.collectioName.updateOne({prop:val},{$set:{prop:newval,...}})
// db.collectioName.updateMany({prop:val},{$set:{prop:newval,...}})
// db.collectionName.updateMany({},{$set:{prop:newval,....}})

db.products.updateOne({_id:ObjectId('65b1e3ea46044a9ddd9d114b')},{$set:{mainCategory:"Culinary",vendor:"Sampada"}})

// to increment or decrement 

db.collectionName.updateOne({},{$set:{prop:{$inc:val}}})

// Query opeartors 

//comparison op

db.products.find({quantity:{$eq:120}})

db.products.find({quantity:{$ne:120}})


db.products.find({category:"Mobiles"})

db.products.find({price:{$lt:1000}})

db.products.find({price:{$gt:1000}})

db.products.find({quantity:{$gte:350}})

db.products.find({vendor:{$in:["Vinayak","Akash"]}})

db.products.find({vendor:{$nin:["Vinayak","Akash"]}})

db.products.find().count()

db.products.find().limit(2)

db.products.find().skip(2)

db.products.find().sort({property:[1,-1]})

// logical op 


db.products.find({price:{$lt:1000},quantity:{$gt:100}})

db.products.find({$and:[{price:{$lt:1000}},{quantity:{$gt:100}}]})

db.products.find({$or:[{price:{$lt:1000}},{quantity:{$gt:120}}]})





db.createCollection('users',{
    validator:{
        $jsonSchema:{
            bsonType:"object",
            required:["name","age","city","hobbies","email","gender"],
            properties:{

                name:{
                    bsonType:"string",
                    description:"Name Field",
                    maxLength:20
                },
                age:{
                    bsonType:"int",
                    description:"Age Field",
                    minimum:12,
                    maximum:100
                },
                city:{
                    bsonType:"string"
                },
                hobbies:{
                    bsonType:"array",
                    minItems:1,
                    maxItems:4,
                    items:{
                        bsonType:"string"
                    }
                },
                email:{
                    bsonType:"string",
                    pattern:"[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$",
                    unique:true
                },
                gender:{
                    bsonType:"string",
                    enum:["Male","Female","Other"]
                }


            }
        }
    }
});


// Agregation 

// $match 
// $group  [$max,$min,$sum,$avg,$push]
// $limit 
// $sort 
// $project
// $filter 
// $unwind
// $lookup 
// $out 

// select city from users 
// group by city 


// normal grouping 
db.users.aggregate([
    
    {
     $group:{_id:"$city","count":{$sum:1}}
    }
 ])

// pushing a single prop 
db.users.aggregate([
    
   {
    $group:{_id:"$city","count":{$sum:1},"names":{$push:"$name"}}
   }
])

// push multiple props 

db.users.aggregate([
    
    {
     $group:{_id:"$city","count":{$sum:1},"people":{$push:{name:"$name",age:"$age"}}}
    }
 ])


//  push the whole doc 


db.users.aggregate([
    
    {
     $group:{_id:"$city","count":{$sum:1},"people":{$push:"$$ROOT"}}
    },

 ])


//  direct sorting

 db.users.aggregate([
    {
        $group:{_id:"$city","count":{$sum:1},"names":{$push:"$name"}}
    },
    {
        $sort:{count:1}
    },
    {
        $project:{count:0}
    }
 ])


 db.users.aggregate([

    {
        $match:{city:"San Francisco"}
    },
    
    {
        $out:"agg_data_sf"
    }

 ])



//  { $filter: { input: <array>, as: <string>, cond: <expression> } }



db.employees.aggregate([
    {
        $lookup:{
            from:"departments",
            localField:"department_id",
            foreignField:"_id",
            as:"department"
        }
    },
    {
        $unwind:"$department"
    }
])


db.departments.aggregate([
    {
        $lookup:{
            from:"employees",
            localField:"_id",
            foreignField:"department_id",
            as:"employees"
        }
    },
    {
        $match:{employees:{$gt:{$size:0}}}
    }
])



db.departments.aggregate([
    {
        $lookup:{
            from:"employees",
            localField:"employees",
            foreignField:"_id",
            as:"employees"
        }
    },
    {
        $unwind:"$employees"
    }
])



db.employees.aggregate([
    {
        $lookup:{
            from:"departments",
            localField:"_id",
            foreignField:"employees",
            as:"department"
        }
    }
])



// Agregation 

// $match 
// $group  [$max,$min,$sum,$avg,$push]
// $limit 
// $sort 
// $project
// $filter 
// $unwind
// $lookup 
// $out 


///

db.users.find({gender:"Male"})

db.users.aggregate([
    {
        $match:{gender:"Male",city:"San Francisco"}
    }
   
])


db.users.aggregate([
   
    {
        $group:{_id:null,"count":{$avg:'$age'}}
    }
   
])


db.users.aggregate([
   
    {
        $group:{_id:'$city',"count":{$sum:1},"people":{$push:"$name"}}
    },
    {
        $project:{count:0}
    },
    {
        $sort:{count:1}
    },
   
    


   
])




// select sum(),city from users 
// group by city

// to create index 

db.collectionName.createIndex({prop:[1,-1]})

db.collectionName.createIndexes([{prop:[1,-1]}...])

// to create a compound index 

db.collectionName.createIndex({prop1:[1,-1],prop2:[1,-1]})

// to view indexes 

db.collectionName.getIndexes()

// to drop index 

db.collectionName.dropIndex("index_name")


// to view stats of queries 


db.collectionName.anyOperation().explain()


db.users.updateOne({name:"Saurabh"},{$set:{age:28,city:"Mumbai",gender:"Male",email:"saurabh@gmail.com",hobbies:["Cricket"]}},{upsert:true})















