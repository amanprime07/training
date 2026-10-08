// Package encoderdecoder provides encoding and decoding helpers
package encoderdecoder

import (
	"strconv"
	"strings"
)

const SEPARATOR = "#"

type Encode interface {
	Encode(arr []string) string
}

type Decode interface {
	Decode(str string) []string
}

type Dencoder struct {
}

func (e *Dencoder) Encode(arr []string) string {
	var builder strings.Builder
	for _, s := range arr {
		l := len(s)
		builder.WriteString(strconv.Itoa(l))
		builder.WriteString(SEPARATOR)
		builder.WriteString(s)
	}
	return builder.String()
}

func (e *Dencoder) Decode(str string) []string {
	arr := make([]string, 0)
	if len(str) == 0 {
		return arr
	}
	var l strings.Builder
	for i := 0; i < len(str); {
		c := string(str[i])
		if c != SEPARATOR {
			l.WriteString(string(str[i]))
			i++
		} else {
			strLen, _ := strconv.Atoi(l.String())
			start := i + 1 + strLen
			temp := str[i+1 : start]
			i = start
			arr = append(arr, temp)
			l.Reset()
		}
	}

	return arr
}
