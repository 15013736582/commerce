var webpack = require('webpack')

module.exports = {

    configureWebpack: {
        plugins: [
            new webpack.ProvidePlugin({
                $: "jquery",
                jQuery: "jquery",
                'windows.jQuery': "jquery"
            })
        ],
    },
    // pages: {
    //     index:
    //         {
    //             template: './public/index.html',
    //             entry: './src/index_page/main.js',
    //             filename: 'index.html'
    //         },
    //     admin:
    //         {
    //             template: './public/index.html',
    //             entry: './src/admin_page/main.js',
    //             filename: 'admin.html'
    //         }
    // },
    devServer: {
        open: process.platform === 'darwin',
        // host: '0.0.0.0',
        port: 8082,
        https: false,
        hotOnly: false,
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/api': '/api',
                }
            },
            '/static': {
                target: 'http://localhost:8080',
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/static':'/static'
                }
            }
        }
    },
};




