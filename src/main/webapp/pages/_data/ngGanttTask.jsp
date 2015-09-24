 <div ng-class="(task.isMilestone() === true && ['gantt-task-milestone'] || ['gantt-task']).concat(task.model.classes)"
     ng-style="{'z-index': (task.active === true && 1  || task.model.priority || ''), 'background-color': task.model.color}">
    <div ng-if="task.truncatedLeft" class="gantt-task-truncated-left"><span>&lt;</span></div>
    <gantt-task-content></gantt-task-content>
    <div ng-if="task.truncatedRight" class="gantt-task-truncated-right"><span>&gt;</span></div>
</div>