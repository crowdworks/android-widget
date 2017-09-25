# -*- coding:utf-8 -*-

import re

css = open("font-awesome.min.css").read()

class Parser:
    def __init__(self, css):
        self.css = css
        self.map = dict()

        self.prev_end = 0
        self.tmp_names = []

    def addGlyphInfo(self, s, start, end):
        self.handle(self.css[self.prev_end:start] if self.prev_end > 0 else "")

        name = s[1:len(s)-len(":before")].replace("-","_")

        if self.prev_end == 0:
            print('<?xml version="1.0" encoding="utf-8"?>')
            print('<resources>')

        self.prev_end = end
        self.tmp_names.append(name)

    def end(self):
        self.handle(self.css[self.prev_end:] if self.prev_end > 0 else "")
        print('</resources>')
            
    def handle(self, text):
        if len(text) > 0:
            m = re.match(r'{content:"\\([0-9a-f]+)"}', text)
            if m is not None:
                for name in self.tmp_names:
                    self.gen(name, "&#x{0};".format(m.group(1)))
                self.tmp_names.clear()

    def gen(self, name, code):
        print('  <string translatable="false" name="{0}">{1}</string>'.format(name, code))


parser = Parser(css)
pattern = re.compile(r'\.fa[-a-z0-9]*:before')
for m in pattern.finditer(css):
    parser.addGlyphInfo(m.group(0), m.start(), m.end())
parser.end()