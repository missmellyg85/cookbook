var path = require('path');
var node_modules_dir = path.join(__dirname, 'node_modules');

module.exports = {
	entry: ["./websrc/app.js"],
	output: {
		path: path.resolve(__dirname, 'src/main/webapp/dist/'),
		filename: "/cookbook.js"
	},
	module: {
		loaders: [
			{
				test: /\.js$/,
				exclude: node_modules_dir,
				loader: 'babel-loader',
				query: {
					cacheDirectory: true,
					presets: ['es2015']
				}
			},
			{
			  test: /\.html$/,
			  loader: "html"
			}
		]
	},
	resolve: {
		extensions: ['', '.js']
	},
	watch: true
}
