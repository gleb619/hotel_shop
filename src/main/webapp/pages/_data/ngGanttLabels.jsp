<div ng-transclude ng-if="showLabelsColumn" class="gantt-labels"
     ng-style="($parent.labelsWidth > 0 && {'width': $parent.labelsWidth+'px'} || {})"
     gantt-labels-resize="$parent.allowLabelsResizing"
     gantt-labels-resize-width="$parent.labelsWidth"
     gantt-labels-resize-min-width="50"
     gantt-element-width-listener="$parent.labelsWidth">
</div>