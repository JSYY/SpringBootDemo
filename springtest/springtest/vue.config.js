module.exports = {
    outputDir: 'F:\\SpringDemo\\src\\main\\resources\\static',
    devServer: {
        open: true,
        host: 'localhost',
        https: false,
        hotOnly: false,
        headers: {
            "Cross-Origin-Embedder-Policy": "require-corp",
            "Cross-Origin-Opener-Policy": "same-origin"
        },
        proxy: {  //配置跨域
            '/api': {
                target: 'http://localhost:8088',  //这里后台的地址模拟的;应该填写你们真实的后台接口
                changOrigin: true,  //允许跨域
                pathRewrite: {
                    '^/api': '/api',//重写,
                }
            }
        }
    },
}