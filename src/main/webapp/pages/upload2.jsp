<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<style>
    .my-drop-zone { 
    	border: dotted 3px lightgray;
    	min-height: 150px; 
    }
    .nv-file-over { border: dotted 3px red; } /* Default class applied to drop zones on over */
    .another-file-over-class { border: dotted 3px green; }
	.separator { height: 2px; background-color: #df691a; }

    html, body { height: 100%; }

    canvas {
        background-color: transparent; 
        /* #f3f3f3; */
        
        -webkit-box-shadow: 5px 5px 5px 1px rgba(38,38,38,1);
		-moz-box-shadow: 5px 5px 5px 1px rgba(38,38,38,1);
		box-shadow: 5px 5px 5px 1px rgba(38,38,38,1);
        
        border: 1px solid white;
        height: 150px;
        z-index: 1000;
        /* margin: 6px 0 0 6px; */
    }
    /* 
    .progress {
    	height: 5px;
    }
     */
    .z-index-900 {
    	z-index: 900;
    }
    
    .boxclose{
	    float:left;
        z-index: 1050;
	    /* margin-top:-10px; */
	    /* 
	    margin-right:-30px;
	    cursor:pointer;
	    color: #fff;
	    /* font-size: 31px; */
	    /* font-weight: bold; */
	    display: inline-block;
	    /* line-height: 0px; */
	    /* padding: 11px 3px; */
	     */
	}

</style>
<div ng-controller="AppController" nv-file-drop="" uploader="uploader">

	<tabset type="pills"> 
			<tab> 
				<tab-heading>
					TEST 
				</tab-heading> 
				
				<div>
				    <carousel interval="myInterval">
				      <slide ng-repeat="slide in slides" active="slide.active">
				        <img ng-src="{{ slide.image }}" style="margin:auto;">
				      </slide>
				    </carousel>
				</div>
			</tab>
			<tab> 
				<tab-heading>
					TEST 2  
				</tab-heading> 
			

	
  
	<div class="row">
		<div class="col-md-9">
	       <div class="well my-drop-zone" nv-file-over="" uploader="uploader" ng-show="uploader.isHTML5">
	           Base drop zone
	       </div>
		</div>
		<div class="col-md-1" style="text-align: center;">
			<h3>OR</h3>
		</div>
		<div class="col-md-2">
			<input type="file" nv-file-select="" uploader="uploader" multiple />
		</div>
	</div>
	<div class="row">
		<hr class="separator">
		
		<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 without-margin" ng-repeat="item in uploader.queue">
			<button type="button" class="btn btn-default btn-delete boxclose" ng-click="item.remove()" style="height: 150px;">
                <span class="glyphicon glyphicon-trash"></span>
            </button>
			<div ng-show="uploader.isHTML5" ng-thumb="{ file: item._file, height: 150 }" class="z-index-900"></div>
		</div>
	</div>
	<div class="row" ng-show="uploader.queue.length > 0">
		<hr class="separator">
		<p>
			Queue length: {{ uploader.queue.length }} 
			<button type="button" class="btn btn-success btn-s" ng-click="uploader.uploadAll()" ng-disabled="!uploader.getNotUploadedItems().length">
                <span class="glyphicon glyphicon-upload"></span> Upload all
            </button>
            <button type="button" class="btn btn-danger btn-s" ng-click="uploader.clearQueue()" ng-disabled="!uploader.queue.length">
                <span class="glyphicon glyphicon-trash"></span> Remove all
            </button>
        </p>
	</div>
</tab>
	</tabset>
</div>