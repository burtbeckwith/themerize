<% attrs.class = attrs.class ?: 'btn btn-success btn-quirk btn-wide mr5'; attrs.value = attrs.value ?: message(code: 'default.button.create.label', default: 'Create') %> ${raw(g.submitButton(attrs, body))}