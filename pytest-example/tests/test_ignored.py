import pytest

@pytest.mark.skip(reason='no way of currently testing this')
class TestIgnoredClass:

    def test_method1_DEV_T40(self):
        assert 1 == 1

    def test_method3_DEV_T41(self):
        assert 5 == 4
