const path = require('path');
const fs = require("fs");
const pbcli = require("protobufjs/cli");

module.exports = function buildProtobuf(inputdir, outdir, js, ts) {
  const protosArr = getFiles(inputdir, '.proto'); // proto文件绝对路径

  if (protosArr && protosArr.length) {
    pbcli.pbjs.main(['-t', 'static-module', '-w', 'es6', '--force-number', '-o', path.resolve(outdir, js), ...protosArr]);
    pbcli.pbts.main(['-o', path.resolve(outdir, ts), path.resolve(outdir, js)]);
  }
}

// 获取扩展名为ext的文件名
function getFiles(url, ext) {
  const fileNames = [];
  const files = fs.readdirSync(url);

  files.forEach(file => {
    const fileurl = path.resolve(url, file);
    const stats = fs.statSync(fileurl);
    if (stats.isFile() && path.extname(fileurl) === ext) {
      console.log('Read Proto: ', path.basename(fileurl));
      fileNames.push(fileurl);
    }
  });
  return fileNames;
}
