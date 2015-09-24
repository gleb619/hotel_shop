<div class="gantt-labels-body"
     ng-style="(maxHeight > 0 && {'max-height': (maxHeight - gantt.header.getHeight())+'px'} || {})">
    <div ng-transclude gantt-vertical-scroll-receiver>
    </div>
</div>