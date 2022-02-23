const path = require('path');
const fs = require('fs');

/**
 * 生成protobuf静态文件
 */
const configs = {
  inputdir: path.resolve(__dirname, './public/proto/mainproto'),
  outdir: path.resolve(__dirname, './public/protobuffer/'), // 输出路径
  js: 'main.proto.js', // 输出js文件名
  ts: 'main.proto.d.ts' // 输出ts文件名
}

const buildProtobuf = require('./public/proto/proto.config');

DeleteFiles();

buildProtobuf(configs.inputdir, configs.outdir, configs.js, configs.ts);

function DeleteFiles() {
    let fileUrl = './public/protobuffer';
    let files = fs.readdirSync(fileUrl);
    files.forEach(item => {
        fs.unlinkSync(fileUrl + '/' + item);
        console.log("delete file:" + item + " success");
    })
}
