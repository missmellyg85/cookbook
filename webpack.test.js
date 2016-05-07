'use strict';

// Modules
var webpack = require('webpack');
var autoprefixer = require('autoprefixer');
var path = require('path');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

var config = {

	entry : {},
	output : {},
	devtool : 'inline-source-map',

	module : {
		//preLoaders: [
		//	{
		//		test: /\.js$/,
		//		exclude: [
		//			/node_modules/,
		//			/\.test\.js$/
		//		],
		//		loader: 'isparta-instrumenter'
		//	}
		//],
		loaders: [{
			test: /\.js$/,
			loader: ['babel'],
			query: {
				presets: ['es2015']
			},
			exclude: /node_modules/
		}, {
			test: /\.(png|jpg|jpeg|gif|svg|woff|woff2|ttf|eot)$/,
			loader: 'file'
		}, {
			test: /\.html$/,
			loader: 'html'
		},
			{
				test: /\.scss$/,
				loader: 'style!css!sass'
			}],

		plugins : [
			new ExtractTextPlugin('[name].[hash].css')
		]
	},

	sassLoader : {
		includePaths: [path.resolve(__dirname, "./websrc/css")]
	},

	devServer : {
		contentBase: './public',
		stats: {
			modules: false,
			cached: false,
			colors: false,
			chunk: false
		}
	}
};

module.exports = config;