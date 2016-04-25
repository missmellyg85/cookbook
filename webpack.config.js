var path = require('path');
var node_modules_dir = path.join(__dirname, 'node_modules');
var ExtractTextPlugin = require("extract-text-webpack-plugin");

var extractCSS = new ExtractTextPlugin('stylesheets/[name].css');

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
				test: /\.scss$/,
				loader: extractCSS.extract(['css','sass'])
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
	plugins: [extractCSS],
	watch: true
}
