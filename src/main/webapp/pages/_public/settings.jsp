<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="col-lg-10 col-lg-offset-1">
	<form class="form-horizontal">
		<fieldset>
			<legend>Local settings</legend>
			
			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<div class="btn-group">
						<button type="submit" class="btn btn-success" ng-click="localSettings('high')">Preset High</button>
						<button type="submit" class="btn btn-warning" ng-click="localSettings('normal')">Preset Normal</button>
						<button type="submit" class="btn btn-danger"  ng-click="localSettings('low')">Preset Low</button>
					</div>
					<div class="btn-group">
						<button type="submit" class="btn btn-default"  ng-click="retest()">Retest</button>
						<button type="submit" class="btn btn-default"  ng-click="clean()">Clean</button>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputAllowModal" class="col-lg-2 control-label">Allow modal</label>
				<div class="col-lg-10">
					<input type="checkbox" id="inputAllowModal" placeholder="Modal windows" ng-model="$storage[settings_key].allow_modal">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputbatch_size" class="col-lg-2 control-label">Batch size</label>
				<div class="col-lg-10">
					<input type="number" class="form-control" id="inputbatch_size" placeholder="Batch size" ng-model="$storage[settings_key].batch_size">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputpower" class="col-lg-2 control-label">Power</label>
				<div class="col-lg-10">
					<input type="checkbox" id="inputpower" placeholder="Is power machine" ng-model="$storage[settings_key].power">
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="cacheble" class="col-lg-2 control-label">Cacheble</label>
				<div class="col-lg-10">
					<input type="checkbox" id="cacheble" placeholder="Is cache content" ng-model="$storage[settings_key].cacheble">
				</div>
			</div>
			
			<div class="form-group">
				<label for="power_level" class="col-lg-2 control-label">Power level</label>
				<div class="col-lg-10">
					<select class="form-control" id="power_level" ng-model="$storage[settings_key].power_level">
						<option value="1">High</option>
						<option value="2">Normal</option>
						<option value="3">Low</option>
					</select> 
					<br> 
				</div>
			</div>
			
			<div class="form-group">
				<label for="power_string" class="col-lg-2 control-label">Power string</label>
				<label id="power_string" class="col-lg-2 control-label">{{ $storage[settings_key].power_string }}</label>
			</div>
			<div class="form-group">
				<label for="elapsed_time" class="col-lg-2 control-label">Elapsed time</label>
				<label id="elapsed_time" class="col-lg-2 control-label">{{ $storage[settings_key].elapsed_time }}</label>
			</div>
			<br>
			<br>
			<br>
			<br>
			<div class="form-group">
				<div class="col-lg-6 col-lg-offset-3">
					<a role="button" class="btn btn-primary form-control" href="#/">Submit</a>
					<!-- <button type="submit" class="btn btn-primary form-control" ng-click="returnToRoot()">Submit</button> -->
				</div>
			</div>
		</fieldset>
	</form>
</div>