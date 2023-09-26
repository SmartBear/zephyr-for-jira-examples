import pytest

class TestClass:

    def test_method_1_DEV_T19(self):
        assert 1 == 1

    @pytest.mark.skip(reason='no way of currently testing this')
    def test_method_2_DEV_T20(self):
        assert 3 == 5

    # will match with test case with key DEV-T21
    def test_method_3_DEV_T21(self):
        assert 5 == 5

    # will match with test case named tests.test_sample.TestClass.test_method
    def test_method(self):
        x = 'this'
        assert 'h' in x

# will match with test case named tests.test_sample.test_method_1_without_class
def test_method_1_without_class():
    assert 1 == 1

def test_method_2_without_class_DEV_T24():
    assert 1 == 0