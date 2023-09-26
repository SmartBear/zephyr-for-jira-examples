using NUnit.Framework;

namespace UnitTest
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [TestCase(2, 2, 4)]
        [TestCase(0, 5, 5)]
        public void Test_AddMethod_NET_T1743(double a, double b, double c)
        {
            double res = a + b;
            Assert.AreEqual(res, c);
        }

        [Test]
        public void Test_SubstractMethod()
        {
            double res = 10 - 10;
            Assert.AreEqual(res, 0);
        }

        [Test]
        public void _NET_T1744_DivideMethod()
        {
            Warn.If(2 + 2 != 5); // this warning will failed, in the resport will be show as skipped
            double res = 10 / 5;
            Assert.AreEqual(res, 2);
        }

        [Test]
        public void Test_MultiplyMethod()
        {

            double res = 10 + 10; // To trace error while testing, writing + operator instead of * operator.
            Assert.AreEqual(res, 100);
        }
    }
}