{{- define "resource.date" -}}
{{- now | htmlDate -}}
{{- end -}}

{{- define "resource.version" -}}
0.1.0
{{- end -}}