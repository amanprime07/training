package encoderdecoder

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestEncode(t *testing.T) {
	arr := []string{"abcd", "efgh"}
	expected := "4#abcd4#efgh"
	sut := &Dencoder{}
	ans := sut.Encode(arr)
	assert.Equal(t, expected, ans)
}

func TestDecode(t *testing.T) {
	str := "4#abcd4#efgh"
	expected := []string{"abcd", "efgh"}
	sut := &Dencoder{}
	ans := sut.Decode(str)
	fmt.Println(ans)
	assert.Equal(t, expected, ans)
}
