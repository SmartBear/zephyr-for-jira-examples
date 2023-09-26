import pytest

# will match with test case with key DEV-T30
@pytest.mark.parametrize('test_input,expected', [('3+5', 8), ('2+4', 7), ('6*9', 42)])
def test_parametrized_DEV_T30(test_input, expected):
    assert eval(test_input) == expected

@pytest.mark.parametrize('test_input,expected', [('3+5', 8), ('2+4', 7), ('6*9', 42)])
def test_parametrized(test_input, expected):
    assert eval(test_input) == expected


@pytest.mark.skip(reason='require further analysis')
@pytest.mark.parametrize('test_input,expected', [('3+5', 8), ('2+4', 6), ('6*9', 42)])
def test_parametrized_DEV_T32(test_input, expected):
    assert eval(test_input) == expected


class TestParametrizedClass:

    @pytest.mark.parametrize('test_input,expected', [('3+5', 8), ('2+4', 6), ('6*9', 42)])
    def test_parametrized_in_class_DEV_T35(self, test_input, expected):
        assert eval(test_input) == expected