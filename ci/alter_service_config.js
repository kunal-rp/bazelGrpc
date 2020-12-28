const fs = require("fs");

//Script to update service tag ; modify BZL global vars
//Expects SERVICE env var from command = build path for service push target

const TAG_DELIM = 0.1
const SERVICE_CONFIG_BZL = "ci/service_configs.bzl"
const SERVICES = ["ACTION", "POLL", "GATEWAY"]

const TAG_ATTR = "TAG"
const TAG_REPO = "REPO"
const serviceRegExp = new RegExp("push_[a-z]*_image")

const SERVICE_NAME = process.env.SERVICE.match(serviceRegExp)[0].split("_")[1].toUpperCase()

if(!SERVICES.includes(process.env.SERVICE.toUpperCase())){
    throw new Error("invalid service:"+process.env.SER)
}

var updateServiceConfig = () =>{

    var updateFileContent = (cont) => {
        var tagLineRegexp = new RegExp(process.env.SERVICE.toUpperCase()+"_TAG=[0-9]*\.[0-9]*")
        var currentTag = cont.match(tagLineRegexp)[0]
        var newTagVersion = (parseFloat(currentTag.split('=')[1]) + TAG_DELIM).toFixed(1)
        var newTagLine = currentTag.split('=')[0] + "=" + newTagVersion

        var newServiceConfig = cont.replace(tagLineRegexp, newTagLine)
        fs.writeFileSync('ci/service_configs.bzl', newServiceConfig  , (err, data) => {
            if (err) {
                throw new Error(err)
              }
            //done, service should be updated
        })

    }

    fs.readFile(SERVICE_CONFIG_BZL, 'utf8' , (err, data) => {
        if (err) {
          throw new Error(err)
        }
        updateFileContent(data)
      })
}

updateServiceConfig()