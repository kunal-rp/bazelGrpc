var grpc = require('@grpc/grpc-js');
const express = require('express')

const app = express()
const port = 3000
const actionServiceProto = require('./action_service_nodejs_proto_pb/proto/action/action_service_grpc_pb.js')
const actionProto = require('./action_service_nodejs_proto_pb/proto/action/action_service_pb.js')

var request = new actionProto.InitializePageRequest();

var client = new actionServiceProto.ActionManagementClient("192.168.64.4:32767", grpc.credentials.createInsecure()); 


app.get('/', (req, res) => {
  res.send('this is a server BIITTCVCH!')
})

app.get('/testgrpc', (req, res) => {
    client.initializePage(new actionProto.InitializePageRequest(), (err, data) => {
        res.json({data : data.toObject(), err: err})
    })
  })

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})