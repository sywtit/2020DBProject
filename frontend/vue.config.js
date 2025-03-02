module.exports = {
    "transpileDependencies": [
        "vuetify"
    ],
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:5000',
                ws: true,
                changeOrigin: true
            }
        },
        historyApiFallback: true
    }
}